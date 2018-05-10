/**
 *
 * Asynchronously loads the component for PaginaInicio
 *
 */

import Loadable from 'react-loadable';

export default Loadable({
  loader: () => import('./index'),
  loading: () => null,
});
