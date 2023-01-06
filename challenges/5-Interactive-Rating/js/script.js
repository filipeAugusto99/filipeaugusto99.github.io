const Main = {
  init: function() {
    this.cacheSelectors()
    this.bindEvents()
  },

  cacheSelectors: function() {
    this.$container = document.querySelector('.hidden1')
    this.$containerThanks = document.querySelector('.card_thanks')
    this.$inputRaiting = document.querySelector('#input-raiting')
    this.$rating = document.querySelector('#rating')
    this.$buttonsGrade = document.querySelectorAll('.buttons-grade')
  },

  bindEvents: function() {
    const self = this
    this.$inputRaiting.onclick = self.Events.inputRaiting_click.bind(this)
    this.$buttonsGrade.forEach(function(button) {
      button.onclick = self.Events.buttonGrade_click.bind(self)
    })
  },

  Events: {
    inputRaiting_click: function() {
      this.$containerThanks.classList.remove('hidden2')
      this.$container.style.display = 'none'
    },
    
    buttonGrade_click: function(e) {
      this.$rating.innerHTML = e.target.innerHTML
    }
  }
}

Main.init()