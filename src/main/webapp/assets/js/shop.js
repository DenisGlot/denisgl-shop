$(function () {
    //solves menu active
    switch (menu) {
        case 'about':
            $('#about').addClass('active');
            break;
        case 'contact':
            $('#contact').addClass('active');
            break;
        case 'listProducts':
            $('#listProducts').addClass('active');
            break;
        default:
            $('#home').addClass('active');
            break;
    }

});