function login() {
    var isValid = $("#ff").form("validate");
    if (isValid) {
        $("#ff").submit();
    }
}

function resetForm() {
    $('#ff').form('reset');
}
