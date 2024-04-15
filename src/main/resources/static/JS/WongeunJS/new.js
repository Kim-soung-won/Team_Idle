window.onload = () => {
    GetListRequest(`/view/POST/productLatest`);
}

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
            const LatestViewController = document.getElementById('field');
            let productsHtml = data.map(item => {
                return `
            <article class="bg-white shadow-md rounded overflow-hidden product-card">
                <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.product_id}"
                     alt="Fashion item" class="w-full h-64 object-cover product-image"
                     onclick=redirectTo(${item.product_id})>
                <div class="p-4">
                    <h3 class="font-semibold">브랜드명 : ${item.product_id}</h3>
                    <h3 class="font-semibold">상품명 : ${item.pd_name}</h3>
                    <p class="text-gray-600">${item.pd_price}원</p>
                    <p class="text-gray-600" >${item.count_love}</p>
                </div>
            </article>
            `;
            }).join('');
            LatestViewController.innerHTML = productsHtml;

            // 이미지에 마우스를 올렸을 때 확대 효과 추가
            const productImages = document.querySelectorAll('.product-image');
            productImages.forEach(image => {
                image.addEventListener('mouseover', function() {
                    this.style.transform = 'scale(1.1)'; // 이미지를 1.1배로 확대
                });

                image.addEventListener('mouseout', function() {
                    this.style.transform = 'scale(1)'; // 이미지 원래 크기로 되돌리기
                });
            });
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}
