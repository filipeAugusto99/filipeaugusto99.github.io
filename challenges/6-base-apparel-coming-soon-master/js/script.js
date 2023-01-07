const formRegistration = document.querySelector('#form_registration')

formRegistration.onsubmit = function(e) {
  e.preventDefault();

  let haveError = false;

  let inputEmail = document.forms['form_registration']['email']

  if (!inputEmail.value || !/^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/.test(inputEmail.value)) {
    haveError = true;
    inputEmail.classList.add('inputError')
    let span = inputEmail.nextSibling.nextSibling.nextElementSibling
    span.innerText = 'Please provide a valid email'
  } else {
    inputEmail.classList.remove('inputError')
    let span = inputEmail.nextSibling.nextSibling.nextElementSibling
    span.innerText = ''
  }

  if(!haveError) {
    formRegistration.submit()
  }
}
