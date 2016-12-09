jQuery(document).ready(function(jQuery) {
    // set focus
    if (jQuery('input.initial_focus')) jQuery('input.initial_focus').focus();
    if (jQuery('#comment_form').length > 0) jQuery('#comment_form').ajaxForm({
     dataType: 'json',
     beforeSubmit: function(data, set, opt) {
      jQuery('input[type=submit], #submit_button', set).attr('disabled', 'disabled');
      jQuery('input[type=submit]', set).attr('value', 'Please wait...');
     },
     success: function(data, code, xhr, set) {
       if (data.status == 'ok') {
        set.clearForm();
        jQuery('#comment_errors').html("<div>Thank  you for your comment.</div>");
        jQuery('#comment_form_wrapper').hide();
        jQuery('a[href$=#comments]').text(""+data.count+" comments");
        var c = "<b>Your  comment is pending moderation and will appear after it is  approved.</b>";
        if (data.moderated == 'false' || data.moderated == false) {
          jQuery('a[href$=#comments]').text(""+data.count+" comments");
          c = '<h3>'+data.params.subject+'</h3><p>From: '+data.params.name+', Just  Posted</p><p>'+data.params.body+'</p>';
        }
        var l = jQuery('#comments > p:first');
        if (l == undefined || l.length == 0)
          jQuery('#comments').prepend(c);
        else
          l.after(c);
       } else {
        jQuery('#comment_form  input[type=submit],#comment_form  #submit_button').removeAttr('disabled').attr('value', 'Submit');
        jQuery('#comment_errors').html("<div><h2>Please correct the following  problems</h2><p>" + data.message + "</p></div>");
       }
     }
   });
});
