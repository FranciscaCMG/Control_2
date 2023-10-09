<template>
    <div class="wrapper fadeInDown">
      <div id="formContent">
        <!-- Tabs Titles -->
        <!-- Icon -->
        <!-- Login Form -->
        <form v-on:submit.right="newTarea">
          <input type="text" id="titulo" class="fadeIn second" name="tarea" placeholder="Titulo de la Tarea" v-model="titulo">
          <input type="text" id="descripcion" class="fadeIn second" name="tarea" placeholder="Descripcion" v-model="descripcion">
          <input type="text" id="fechaCreacion" class="fadeIn second" name="tarea" placeholder="Fecha de Inicio" v-model="fechaCreacion">
          <input type="text" id="fechaFin" class="fadeIn third" name="tarea" placeholder="Fecha de Fin" v-model="fechaFin">
          <input type="text" id="prioridad" class="fadeIn third" name="tarea" placeholder="Prioridad" v-model="prioridad">
          <input type="submit" class="fadeIn fourth" value="Crear Tarea">
        </form>
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
      },
    }
  },
  methods: {
    register() {
      let json = {
      "titulo" : this.titulo,
      "descripcion" : this.descripcion,
      "fechaCreacion" : this.fechaCreacion,
      "fechaFin" : this.fechaFin,
      "estado" : 'En curso',
      "prioridad" : this.prioridad,
      "rut" : '25100345-9' 
      };
      axios.post("http://localhost:8086/tarea", json)
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