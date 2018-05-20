<h1 class="my-4">Shop</h1>
<div class="list-group">
    <c:forEach items="${categories}" var="category">
        <a href="${contextRoot}/category/${category.id}" class="list-group-item" id="category_${category.name}">${category.name}</a>
    </c:forEach>
</div>