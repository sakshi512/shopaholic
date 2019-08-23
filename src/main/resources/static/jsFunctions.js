///
function addtoCart() {
    var prevCount = parseInt(document.getElementById("cart").innerHTML);
    prevCount += 1;
    document.getElementById("cart").innerHTML = prevCount.toString();

}


