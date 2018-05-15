/**
 *
 * Asynchronously loads the component for ReservaVuelo
 *
 */

import Loadable from 'react-loadable';

export default Loadable({
  loader: () => import('./index'),
  loading: () => null,
});
