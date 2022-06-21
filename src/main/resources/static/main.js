window.onload = function () {
window.addEventListener('scroll', function (e)
    {
         if (window.pageYOffset > 65)
            {
             document.querySelector("header").classList.add('is-scrolling');
            } 
        else 
            {
            document.querySelector("header").classList.remove('is-scrolling');
            }
    });
}

// window.onload = function () {
//   alert("Message Sent!")
// }
 
function myFunction() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName('li');

    for (i = 0; i < li.length; i++) {
      a = li[i].getElementsByTagName("a")[0];
      txtValue = a.textContent || a.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        li[i].style.display = "";
      } else {
        li[i].style.display = "none";
      }
    }
  }