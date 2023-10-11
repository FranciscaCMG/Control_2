<template>
    <div class="container">
        <h1 class="text-center"> Tus Tareas</h1>
        <table class="table table-striped">
            <thead>
                <th>Titulo</th>
                <th>Descripcion</th>
                <th>Estado</th>
                <th>Prioridad</th>
                <th>Fecha de Creacion</th>
                <th>Fecha de Finalizacion</th>
            </thead>
            <tbody>
                <tr v-for="tarea in tareas" v-bind:key="tarea.id_tarea">
                    <td> {{ tarea.titulo }}</td>
                    <td> {{ tarea.descripcion }}</td>
                    <td> {{ tarea.estado }}</td>
                    <td> {{ tarea.prioridad }}</td>
                    <td> {{ tarea.fechaCreacion }}</td>
                    <td> {{ tarea.fechaFin }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import TareasServices from '../services/TareasServices'

export default {
  name: 'ListaTareas',
  data() {
    return {
      tareas: []
    };
  },
  methods: {
    getTareas() {
      TareasServices.getTareas().then((response) => {
        this.tareas = response.data;

      })
      .catch(error => {
        console.error(error);
      });
    }
  },
  created() {
    this.getTareas();
  }
}
</script>