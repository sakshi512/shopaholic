/// Add a product to the Cart
function addtoCart(userId, productId) {
    var prevCount = parseInt(document.getElementById("cart").innerHTML);
    prevCount += 1;
    document.getElementById("cart").innerHTML = prevCount.toString();

    var ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
           // alert(this.responseText);
        }
    };
    ajaxRequest.open("GET", "/api/addCart?productId="+productId+"&userId="+userId, true);
    ajaxRequest.send();

}