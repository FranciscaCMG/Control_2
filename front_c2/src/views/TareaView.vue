<template>
  <div class="container">
    <div class="row">
      <h1 class="text-center">Crear Tarea</h1>
      <div class="class= col-lg-4 col-md-6 col-sm-12 mx-auto">
        <div class="card-body">
          <div class="wrapper fadeInDown">
            <div id="formContent">
              <!-- Tabs Titles -->
              <!-- Icon -->
              <!-- Login Form -->
              <form v-on:submit.prevent="tarea" method = "post">
                <input type="text" id="titulo" class="form-control" name="tarea" placeholder="Titulo de la Tarea"
                  v-model="newTarea.titulo">
                <input type="text" id="descripcion" class="form-control" name="tarea" placeholder="Descripcion"
                  v-model="newTarea.descripcion">
                <input type="text" id="fechaCreacion" class="form-control" name="tarea" placeholder="Fecha de Inicio"
                  v-model="newTarea.fechaCreacion">
                <input type="text" id="fechaFin" class="form-control" name="tarea" placeholder="Fecha de Fin"
                  v-model="newTarea.fechaFin">
                <input type="text" id="prioridad" class="form-control" name="tarea" placeholder="Prioridad"
                  v-model="newTarea.prioridad">
                <input type="submit" class = "btn btn-success" value="Crear Tarea">
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios';

export default {
  name: 'TareaView',
  data() {
    return {
      newTarea: {
        titulo: '',
        descripcion: '',
        fechaCreacion: '',
        fechaFin: '',
        estado: '',
        prioridad: '',
        rut: ''
      }
    };
  },
  methods: {
    tarea() {
      axios.post("http://localhost:8086/tarea", {
        "titulo": this.newTarea.titulo,
        "descripcion": this.newTarea.descripcion,
        "fechaCreacion": this.newTarea.fechaCreacion,
        "fechaFin": this.newTarea.fechaFin,
        "estado": 'En curso',
        "prioridad": this.newTarea.prioridad,
        "rut": "19999998-k"
      })
      this.$router.push('/tareas')
        .then(response => {
          console.log(response.data);
          
        })
        .catch(error => {
          console.error(error);
        });
    }
  }
}
</script>