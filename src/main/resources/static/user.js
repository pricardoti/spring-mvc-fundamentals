$(document).ready(() => {
    $.ajax({
        url: "http://localhost:8080/conference/user"
    }).then((data) => {
        $('[name="firstname"]').append(data.firstname);
        $('[name="lastname"]').append(data.lastname);
        $('[name="age"]').append(data.age);
    });
});