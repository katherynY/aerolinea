/**
 *
 * Asynchronously loads the component for ConsultaVuelos
 *
 */

import Loadable from 'react-loadable';

export default Loadable({
  loader: () => import('./index'),
  loading: () => null,
});
