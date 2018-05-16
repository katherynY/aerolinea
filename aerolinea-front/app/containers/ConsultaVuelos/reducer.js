/*
 *
 * ConsultaVuelos reducer
 *
 */

import { fromJS } from 'immutable';
import {
  DEFAULT_ACTION,
} from './constants';

const initialState = fromJS({
  vuelos: false,
  reservas: [],
});

function consultaVuelosReducer(state = initialState, action) {
  switch (action.type) {
    case 'GUARDAR_RESPUESTA':
      return state.set('vuelos', action.value);
    default:
      return state;
  }
}

export default consultaVuelosReducer;
