const menuMobile = document.querySelector('.navbar')
const menu = document.querySelector('.menu-image')

let open = false;

menu.onclick = function() {
  if(!open === true) {
    open = true
    menuMobile.classList.add('open')
    return
  }
  open = false
  menuMobile.classList.remove('open')
}