<div class="container">
    <div class="row">

        <div class="col-md-3">
            <%@include file="shared/sidebar.jsp"%>
        </div>

        <div class="col-md-9">
            <div class="row">
                <div class="col-lg-12">
                    <script>
                        window.categoryId = '${category.id}';
                        window.contextRoot = '${contextRoot}';
                    </script>
                    <ol class="breadcrumb">
                        <li><a href="${contextRoot}/home">Home </a></li>
                        <li class="active"> / Category </li>
                        <li class="active"> / ${category.name} </li>
                    </ol>

                    <div class="col-xs-12">

                        <table id="js-productListTable" class="table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th></th>
                                    <th>Name</th>
                                    <th>Brand</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th></th>
                                    <th>Name</th>
                                    <th>Brand</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th></th>
                                </tr>
                            </tfoot>

                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
