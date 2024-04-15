document.addEventListener("DOMContentLoaded", function() {
    // Get product list from API
    GetListRequest(`/api/GET/productList`);
});

function redirectTo(id){
    location.href=`/product/?id=${id}`;
}

function GetListRequest(url){
    const headers = {
        'Content-Type': 'application/json',
    };
    fetch(url, {
        method: 'POST',
        headers: headers
    })
        .then(response => response.json())
        .then(data => {
            // Get the product container
            const productContainer = document.getElementById('field');

            // Generate HTML for each product item
            let productsHtml = data.map(item => {
                return `
                            <article class="product-card bg-white rounded overflow-hidden">
                                <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.product_id}"
                                     alt="Fashion item" class="w-full h-64 object-cover product-image"
                                     onclick="redirectTo(${item.product_id})">
                                <div class="p-4">
                                    <h3 class="font-semibold">브랜드명 : ${item.product_id}</h3>
                                    <h3 class="font-semibold">상품명 : ${item.pd_name}</h3>
                                    <p class="text-gray-600">${item.pd_price}원</p>
                                    <p class="text-gray-600" >${item.count_love}</p>
                                </div>
                            </article>
                            `;
            }).join(''); // Join all product items into a single string

            // Update the product container with the generated HTML
            productContainer.innerHTML = productsHtml;
        })
        .catch(error => {
            console.error('Error fetching product data:', error);
        });
}