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
        case 'home':
            $('#home').addClass('active');
        default:
            $('#category_' + menu).addClass('active');
            break;
    }

});