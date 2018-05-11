/**
 *
 * PaginaInicio
 *
 */
import styled from 'styled-components';
import React from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { FormattedMessage } from 'react-intl';
import { createStructuredSelector } from 'reselect';
import { compose } from 'redux';

import injectSaga from 'utils/injectSaga';
import injectReducer from 'utils/injectReducer';
import makeSelectPaginaInicio from './selectors';
import reducer from './reducer';
import saga from './saga';
import messages from './messages';
import NavigationBar from '../../components/NavigationBar';
import FloatForm from '../../components/FloatForm';



export class PaginaInicio extends React.Component { // eslint-disable-line react/prefer-stateless-function
  render() {
    return (
      <section>
        <div className="ContentImg">
          <div className="CImg">
          </div>
          <FloatForm></FloatForm>
        </div>
      </section>
    );
  }
}

PaginaInicio.propTypes = {
  dispatch: PropTypes.func.isRequired,
};

const mapStateToProps = createStructuredSelector({
  paginainicio: makeSelectPaginaInicio(),
});

function mapDispatchToProps(dispatch) {
  return {
    dispatch,
  };
}

const withConnect = connect(mapStateToProps, mapDispatchToProps);

const withReducer = injectReducer({ key: 'paginaInicio', reducer });
const withSaga = injectSaga({ key: 'paginaInicio', saga });

export default compose(
  withReducer,
  withSaga,
  withConnect,
)(PaginaInicio);
