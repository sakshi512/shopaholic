/// Add a product to the Cart
function addtoCart(userId, productId, price) {
    var prevCount = parseInt(document.getElementById("cart").innerHTML);
    var qty = prevCount + 1;
    var ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

            document.getElementById("cart").innerHTML = qty.toString();
        }
    };
    ajaxRequest.open("GET", "/api/addCart?productId="+productId+"&userId="+userId+"&qty="+qty+"&price="+price, true);
    ajaxRequest.send();

}
/// delete cart item
function deleteCart(cartId)
{
    var ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

            window.location.reload();
        }
    };
    ajaxRequest.open("GET", "/api/delCart?cartId="+cartId, true);
    ajaxRequest.send();
}


function validateForm()
{
    var pin_code=document.getElementById("txtPin");
    var user_mobile=document.getElementById("txtPhone");
   //var user_id=document.getElementById("email");
    var pat1=/^\d{6}$/;
    var pattern=/^\d{10}$/;
    // var filter=/^([a-z A-Z 0-9 _\.\-])+\@(([a-z A-Z 0-9\-])+\.)+([a-z A-z 0-9]{3,3})+$/;
    // if(!filter.test(user_id.value))
    // {
    //     alert("Email is in www.gmail.com format");
    //     user_id.focus();
    //     return false;
    // }
    if(!pattern.test(user_mobile.value))
    {
        alert("Phone number accepts only 10 digit number format ");
        user_mobile.focus();
        return false;
    }
    if(!pat1.test(pin_code.value))
    {
        alert("Pin code should be 6 digits number only");
        pin_code.focus();
        return false;
    }
}