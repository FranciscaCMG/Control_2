import Vue from 'vue'
import VueRouter from 'vue-router'
//import HomeView from '../views/RegisterView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/usuario',
    name: 'usuario',
    component: () => import('../views/RegisterView.vue')
  },
  {
    path: '/tarea',
    name: 'tarea',
    component: () => import('../views/TareaView.vue')
  },
  {
    path: '/tareas',
    name: 'tareas',
    component: () => import('../views/TareasAllView.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/LoginView.vue')
  },
  {
    
    path: '/editar-tarea/:id',
    name: 'editar-tarea',
    component: () => import('../views/EditarTarea.vue')
  },

  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


export default router