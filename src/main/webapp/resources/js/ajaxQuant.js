$(document).ready(function () {
    var $form = $("#addquantity");
    $form.on('submit', function (e) {
        e.preventDefault();
        $.ajax({
            url: $form.attr('action'),
            type: 'POST',
            dataType: 'json',
            data: $form.serialize(),
            success: function (result) {
                console.log(result);
            },
            error: function (xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        })
    })
})