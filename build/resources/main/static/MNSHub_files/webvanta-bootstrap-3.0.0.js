/*
 * WebvantaAdmin collects various generic utils needed everywhere
 * Copyright (c) 2015 Webvanta Inc
 *
 * Script loaders from "Event Faster Web Sites" code by Steve Souders
 */
/*
 * Define the WEBVANTA global namespace object. Don't overwrite if it exists.
 */
if ( typeof(WebvantaAdmin) == 'undefined' || !WebvantaAdmin) {
    var WebvantaAdmin = {};
}

WebvantaAdmin = {
    version: "3.0.0",

    // Cookie routines thanks to jQuery cookie plugin by  Klaus Hartl
    // Copyright (c) 2006 Klaus Hartl (stilbuero.de)
    // Dual licensed under the MIT and GPL licenses:

    readCookie: function ( name ) {
      var nameEQ = name + "=";
      var ca = document.cookie.split(';');
      for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
      }
      return null;
    },

    writeCookie: function ( name, value, options ) {
      options = options || {};
       if (value === null) {
           value = '';
           options.expires = -1;
       }
       var expires = '';
       if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
           var date;
           if (typeof options.expires == 'number') {
               date = new Date();
               date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
           } else {
               date = options.expires;
           }
           expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
       }
       var path = options.path ? '; path=' + options.path : '';
       var domain = options.domain ? '; domain=' + options.domain : '';
       var secure = options.secure ? '; secure' : '';
       document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    },

    isAdmin: function ( ) {
      var uir;
      if (uir = WebvantaAdmin.readCookie("wv_user_info")) {
        var user_info = decodeURIComponent(uir).split(',');
        var r;
        return (user_info && user_info[1] && (r = user_info[1].split('=')) && r[1].match(/(admin|content.editor|support|super)/) != null);
      }
      return false;
    },

    getKeyValue: function ( co_name, key ) {
      var co;
      if (co = WebvantaAdmin.readCookie(co_name)) {
        var kvary = decodeURIComponent(co).split(',');
        if (kvary) {
          for(var i=0; i < kvary.length;i++) {
            if (kvary[i]) {
              var kv = kvary[i].split('=');
              if (kv[0] == key) {
                if (kv[1])
                  return kv[1].replace(/\+/g,' ');
                else
                  return '';
              }
            }
          }
        }
      }
      return '';
    },

    getUIRValue: function ( name ) {
      return WebvantaAdmin.getKeyValue("wv_user_info", name);
    },

    getSetting: function ( name ) {
      return WebvantaAdmin.getKeyValue("wv_settings", name);
    },

    /* From EFWS */

    queuedScripts: new Array(),

    loadScriptXhrInjection: function(url, onload, bOrder) {
      var iQueue = WebvantaAdmin.queuedScripts.length;
      if ( bOrder ) {
        var qScript = { response: null, onload: onload, done: false };
        WebvantaAdmin.queuedScripts[iQueue] = qScript;
      }

      var xhrObj = WebvantaAdmin.getXHRObject();
      xhrObj.onreadystatechange = function() {
        if ( xhrObj.readyState == 4 ) {
          if ( bOrder ) {
            WebvantaAdmin.queuedScripts[iQueue].response = xhrObj.responseText;
            WebvantaAdmin.injectScripts();
          }
          else {
            var se = document.createElement('script');
            document.getElementsByTagName('head')[0].appendChild(se);
            se.text = xhrObj.responseText;
            if ( onload ) {
              onload();
            }
          }
        }
      };
      xhrObj.open('GET', url, true);
      xhrObj.send('');
    },

    injectScripts: function() {
      var len = WebvantaAdmin.queuedScripts.length;
      for ( var i = 0; i < len; i++ ) {
        var qScript = WebvantaAdmin.queuedScripts[i];
        if ( ! qScript.done ) {
          if ( ! qScript.response ) {
            // STOP! need to wait for this response
            break;
          }
          else {
            var se = document.createElement('script');
            document.getElementsByTagName('head')[0].appendChild(se);
            se.text = qScript.response;
            if ( qScript.onload ) {
              qScript.onload();
            }
            qScript.done = true;
          }
        }
      }
    },

    getXHRObject: function() {
      var xhrObj = false;
      try {
        xhrObj = new XMLHttpRequest();
      }
      catch(e){
        var aTypes = ["Msxml2.XMLHTTP.6.0",
                "Msxml2.XMLHTTP.3.0",
                "Msxml2.XMLHTTP",
                "Microsoft.XMLHTTP"];
        var len = aTypes.length;
        for ( var i=0; i < len; i++ ) {
          try {
            xhrObj = new ActiveXObject(aTypes[i]);
          }
          catch(e) {
            continue;
          }
          break;
        }
      }
      finally {
        return xhrObj;
      }
    },

    loadCSS: function(href) {
      var linkRef = document.createElement("link");
      linkRef.setAttribute("rel", "stylesheet")
      linkRef.setAttribute("type", "text/css")
      linkRef.setAttribute("href", href)
      document.getElementsByTagName('head')[0].appendChild(linkRef);
    }

};

WebvantaAdmin.addHandler = function(elem, type, func) {
	if ( elem.addEventListener ) {
		elem.addEventListener(type, func, false);
	}
	else if ( elem.attachEvent ) {
		elem.attachEvent("on" + type, func);
	}
};

if (WebvantaAdmin.isAdmin()) {
  if (typeof(WebvantajQuery) == 'undefined' || !WebvantajQuery) {

    WebvantaAdmin.loadCSS("/webvanta/admin/v2/css/edit.css");
    WebvantaAdmin.loadCSS("/webvanta/admin/v2/css/colorbox.css");
    WebvantaAdmin.loadCSS("/webvanta/admin/v2/css/webvanta-code-editor-1.0.0.css");

    WebvantaAdmin.loadScriptXhrInjection("/webvanta/admin/v3/js/webvanta-bootstrap-combined-3.0.0.js", null, true);
    WebvantaAdmin.loadScriptXhrInjection("/webvanta/admin/v3/js/webvanta-admin-3.0.0.js", null, true);
  }
}
