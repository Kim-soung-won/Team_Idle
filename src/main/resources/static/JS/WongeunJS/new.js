window.onload = () => {
<<<<<<< HEAD
    GetListRequestByCreatedAt(`/view/GET/CreatedAt?page=1`);
=======
    GetListRequest(`/view/GET/productLatest`);
>>>>>>> 94498bf94cd58287e163d1f2534f96ee616f0b25
}

function redirectTo(id){
    location.href=`/product/?id=${id}`;
}
<<<<<<< HEAD

function GetListRequestByCreatedAt(url){
=======
function GetListRequest(url){
>>>>>>> 94498bf94cd58287e163d1f2534f96ee616f0b25
    const headers = {
        'Content-Type': 'application/json',
    };
    fetch(url, {
        method: 'POST',
        headers: headers
    })
        .then(response => response.json())
        .then(data => {
<<<<<<< HEAD
            // Thymeleaf로 직접 데이터 추가
            const LatestViewController = document.getElementById('qwe12');
            // 데이터 배열을 순회하면서 각 항목을 HTML로 변환
=======
            const LatestViewController = document.getElementById('field');
>>>>>>> 94498bf94cd58287e163d1f2534f96ee616f0b25
            let productsHtml = data.map(item => {
                return `
                <article class="product-item bg-white shadow-md rounded overflow-hidden">
                    <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.product_id}"
                         alt="Fashion item" class="w-full h-64 object-cover"
                         onclick="redirectTo(${item.product_id})">
                    <div class="p-4">
                        <h3 class="font-semibold">브랜드명 : ${item.product_id}</h3>
                        <h3 class="font-semibold">상품명 : ${item.pd_name}</h3>
                        <p class="text-gray-600">${item.pd_price}원</p>
                        <p class="text-gray-600">좋아요 ${item.count_love}</p>
                        <p class="text-gray-600">댓글 ${item.comment_count}</p>
                    </div>
                </article>
            `;
            }).join('');
            LatestViewController.innerHTML = productsHtml;
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}


