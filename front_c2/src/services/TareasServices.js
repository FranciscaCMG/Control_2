import axios from 'axios'

const TAREAS_API_URL = 'http://localhost:8086/tarea'

class TareaService{
    getTareas(){
        return axios.get(TAREAS_API_URL);
    }
}

export default new TareaService()