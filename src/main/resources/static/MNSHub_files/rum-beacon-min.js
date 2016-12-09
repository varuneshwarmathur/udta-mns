(function(){
	if(rumMOKey && (rumMOKey.length == 32 || rumMOKey.length == 40)){
		var validateScriptTag = document.createElement('script');//No I18N
		validateScriptTag.setAttribute('src','//static.site24x7rum.com/beacon/site24x7rum-min.js?appKey='+rumMOKey+'&rumCB=responseHandler');//No I18N
		document.getElementsByTagName('head').item(0).appendChild(validateScriptTag);
	}
})(window);