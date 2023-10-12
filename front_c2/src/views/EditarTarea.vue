<template>
  <div class="container">
    <h1 class="text-center">Editar Tarea {{ $route.params.id }}</h1>
    <form @submit.prevent="guardarEdicion">
      <div class="form-group">
        <label for="titulo">Título</label>
        <input type="text" class="form-control" id="titulo" v-model="newTarea.titulo" required>
      </div>
      <div class="form-group">
        <label for="descripcion">Descripción</label>
        <textarea class="form-control" id="descripcion" v-model="newTarea.descripcion" required></textarea>
      </div>
      <div class="form-group">
        <label for="fechaFin">Fecha de Finalización</label>
        <input type="date" class="form-control" id="fechaFin" v-model="newTarea.fechaFin" required>
      </div>
      <div class="form-group">
        <label for="estado">Estado</label>
        <input type="text" class="form-control" id="estado" v-model="newTarea.estado" required>
      </div>
      <div class="form-group">
        <label for="prioridad">Prioridad</label>
        <input type="text" class="form-control" id="prioridad" v-model="newTarea.prioridad" required>
      </div>
      <button type="submit" class="btn btn-primary">Guardar Cambios</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'EditarTarea',
  data() {
    return {
      newTarea: {
        titulo: '',
        descripcion: '',
        fechaCreacion: '',
        fechaFin: '',
        estado: '',
        prioridad: '',
        rut: 'hola'
      }
    };
  },
  methods: {
    guardarEdicion() {
      axios.put(`http://localhost:8086/edit-tarea/${this.$route.params.id}`, {
        "titulo": this.newTarea.titulo,
        "descripcion": this.newTarea.descripcion,
        "fechaCreacion": this.newTarea.fechaCreacion,
        "fechaFin": this.newTarea.fechaFin,
        "estado": this.newTarea.estado,
        "prioridad": this.newTarea.prioridad,
        "rut": this.newTarea.rut
      })
      .then(response => {
        console.log('Tarea actualizada:', response.data);
        this.$router.push('/tareas');
      })
      .catch(error => {
        console.error('Error al actualizar la tarea:', error);
      });
    }
  }
};
</script>
