import { createSelector } from 'reselect';

/**
 * Direct selector to the consultaVuelos state domain
 */
const selectConsultaVuelosDomain = (state) => state.get('consultaVuelos');

/**
 * Other specific selectors
 */


/**
 * Default selector used by ConsultaVuelos
 */

const makeSelectConsultaVuelos = () => createSelector(
  selectConsultaVuelosDomain,
  (substate) => substate.toJS()
);

export default makeSelectConsultaVuelos;
export {
  selectConsultaVuelosDomain,
};
