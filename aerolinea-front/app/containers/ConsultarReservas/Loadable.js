/**
 *
 * Asynchronously loads the component for ConsultarReservas
 *
 */

import Loadable from 'react-loadable';

export default Loadable({
  loader: () => import('./index'),
  loading: () => null,
});
