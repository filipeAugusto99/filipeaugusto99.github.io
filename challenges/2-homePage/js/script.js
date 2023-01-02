const Main = {
  init: function() {
    this.cacheSelectors()
    this.bindEvents()
  },

  cacheSelectors: function() {
    this.$nav = document.querySelector("nav")
    this.$openMenu = document.getElementById("menu-button")
    this.$closeMenu = document.getElementById("menu-close")
  },

  bindEvents: function() {
    const self = this
    this.$openMenu.onclick = self.Events.menuOpen_click.bind(this)
    this.$closeMenu.onclick = self.Events.menuClose_click.bind(this)
  },

  Events: {
    menuOpen_click: function() {
      this.$nav.classList.add("open")
    },

    menuClose_click: function() {
      this.$nav.classList.remove("open")
    }
  }
}


Main.init()