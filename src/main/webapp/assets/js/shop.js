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

    //dataTable

    var contextRoot = window.contextRoot;

    var jsonUrl = contextRoot + '/json/data/category/' + window.categoryId;

    var $table = $('#js-productListTable');

    if ($table.length) {
        $table.DataTable({
            ajax: {
                url: jsonUrl,
                dataSrc: '',

            },
            columns: [
                {
                    data: 'name'
                },
                {
                    data: 'brand'
                },
                {
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return data + '&yen; ';
                    }
                },
                {
                    data: 'quantity'
                },
                {
                    data: 'id',
                    mRender: function (data, type, row) {

                        return '<a href="' + contextRoot + '/product/' + data + '" class="btn btn-primary">View</a>';
                    }
                }
            ],
            lengthMenu: [[3, 5, 10 , -1], ["3 products", "5 products", "10 products", "all products"]],
            pageLength: 5
        });

    }

});