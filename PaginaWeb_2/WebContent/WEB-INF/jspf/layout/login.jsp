<script>function validateForm()
{
var x=document.forms["myForm"]["uname"].value;
if (x==null || x=="")
  {
  alert("Por favor Digite un Usuario");
  document.getElementById('uname').focus();
  return false;
  }
var y=document.forms["myForm"]["psw"].value;
if (y==null || y=="")
  {
  alert("Por favor Digite una contraseña");
  document.getElementById('psw').focus();
  return false;
  }
}
</script>
<div id="id01" class="modal">
  
  <form class="modal-content animate" method="post" name="myForm" onsubmit="return validateForm()" action="<%=request.getContextPath()%>
/LoginServlet">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="images/user.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="uname" required>

      <label><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
      
    <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>

      <button type="submit">Login</button>
      <input type="checkbox" checked="checked"> Remember me
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
  </form>
</div>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>