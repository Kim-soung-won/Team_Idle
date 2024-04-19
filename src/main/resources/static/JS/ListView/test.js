window.onload = () => {
    GetListRequestTest(`/api/GET/productList`);
}

function redirectTo(id){
    location.href=`/product/?id=${id}`;
}

function GetListRequestTest(url) {
    const headers = {
        'Content-Type': 'application/json',
    };
    fetch(url, {
        method: 'POST',
        headers: headers
    })
        .then(response => response.json())
        .then(data => {
            data.sort((a, b) => a.pd_price - b.pd_price);
            const productDataContainer = document.getElementById('field')

            let productsHtml = data.map(item => {
                return `
                <article class="bg-white shadow-md rounded overflow-hidden">
<<<<<<< HEAD
                    <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.product_id}"
                         alt="Fashion item" class="w-full h-64 object-cover"
                         onclick="redirectTo(${item.product_id})">
=======
                <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.product_id}"
                                 alt="Fashion item"
                                 onclick="redirectTo(${item.product_id})">
>>>>>>> 3781523326be989b59d8f1bf8cd1118b9a00421a
                         
                    <div class="p-4">
                        <h3 class="font-semibold">상품ID : ${item.product_id}</h3>
                        <h3 class="font-semibold">상품명 : ${item.pd_name}</h3>
                        <p class="text-gray-600">${item.pd_price}원</p> 
                        <p class="text-gray-600">${item.count_love}</p>
                    </div>
                </article>`
            }).join('');
            productDataContainer.innerHTML = productsHtml

        })
        .catch(error=>{
            console.error('Error fetching user data:', error);
        })
}

