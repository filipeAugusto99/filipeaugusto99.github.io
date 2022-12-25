const Main = {
  tasks: [],

  init: function() {
    this.cacheSelectors()
    this.bindEvent()
    this.getStoraged()
    this.buildTasks()
    this.getTasksHtml()
  },

  cacheSelectors: function(){
    this.$buttonsChecks = document.querySelectorAll('.check')
    this.$inputTask = document.querySelector('#inputTask')
    this.$list = document.querySelector('.list')
    this.$remove = document.querySelectorAll('.remove')
  },
  
  getStoraged: function() {
    const tasks = localStorage.getItem('tasks')
    this.tasks = JSON.parse(tasks)
  },

  getTasksHtml: function(task, done) {
    //if ternário: (done ? 'done' : '') "?"" se for true faça isso; ":" caso contrário se false faça isso
    return  `  
      <li class="${done ? 'done': ''}"> 
        <div class="check"></div>
        <label class="task">
          ${task}
        </label>
        <button class="remove" data-task="${task}"></button>
      </li>
    `
  },

  buildTasks: function() {
    let html = ''
    this.tasks.forEach(item => {
      html += this.getTasksHtml(item.task, item.done)
    })
    this.$list.innerHTML = html
    this.cacheSelectors()
    this.bindEvent()
  },

  bindEvent: function() {
    const self = this
    this.$buttonsChecks.forEach(button => button.onclick = self.Event.buttonCheck_click)
    this.$inputTask.onkeypress = self.Event.inputTask_click.bind(this)
    this.$remove.forEach(button => button.onclick = self.Event.removeTasks_click.bind(self))
  },

  Event: {
    buttonCheck_click: function(e) {
      const li = e.target.parentElement
      const isDone = li.classList.contains('done')
  
      const value = li.querySelector('.task').innerText
      const tasks = JSON.parse(localStorage.getItem('tasks'))
      const task = tasks.find(item => item.task === value)
      task.done = !task.done
      localStorage.setItem('tasks', JSON.stringify(tasks))

      if(!isDone) {
        return li.classList.add('done')
      }
      li.classList.remove('done')
    },

    inputTask_click: function(e) {
      const key = e.key
      const value = e.target.value
      
      if(key === 'Enter') {
        this.$list.innerHTML += this.getTasksHtml(value)
        e.target.value = ''
        
        this.cacheSelectors()
        this.bindEvent()
        
        const savedTasks = localStorage.getItem('tasks')
        const savedTasksObj = JSON.parse(savedTasks)

        const obj = [
          { task: value, done: false },
          ...savedTasksObj
        ]
  
        localStorage.setItem('tasks', JSON.stringify(obj))
      }
    },

    removeTasks_click: function(e) {
      const li = e.target.parentElement
      const value = e.target.dataset['task']

      const newTaskState = this.tasks.filter(item => item.task !== value)
      localStorage.setItem('tasks', JSON.stringify(newTaskState))

      li.classList.add('removed')

      setTimeout(() => li.classList.add('hidden'), 300)
    }

  }
}

Main.init()