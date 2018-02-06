$(document).ready(function() {
    $(".addToCart").click(function() {
        $.ajaxPrefilter(function (options, originalOptions, jqXHR) {
            jqXHR.setRequestHeader('X-CSRF-Token', $("#csrfToken").val());
        });
        $.ajax({
            url: '/api/cart',
            type: 'POST',
            data: JSON.stringify({
                "product_id": 1
            }),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            async: false,
            success: function(msg) {
                alert(msg);
            }
        });
    });

    $(".clickToBuy").click(function() {
        alert(2);
    });
});