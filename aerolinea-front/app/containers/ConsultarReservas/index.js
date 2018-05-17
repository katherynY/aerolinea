/**
 *
 * ConsultarReservas
 *
 */
import React from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { createStructuredSelector } from 'reselect';
import { compose } from 'redux';

import injectSaga from 'utils/injectSaga';
import injectReducer from 'utils/injectReducer';
import makeSelectConsultarReservas from './selectors';
import reducer from './reducer';
import saga from './saga';
import axios from 'axios';

export class ConsultarReservas extends React.Component { // eslint-disable-line react/prefer-stateless-function

  constructor(props) {
    super(props);
    this.onFormSubmit = this.onFormSubmit.bind(this);
  }

  onFormSubmit(e) {
    e.preventDefault();
    this.props.consultarReservas();
  }

  render() {
    const listaReservas = this.props.consultarreservas.reservas
      && this.props.consultarreservas.reservas.map((item) => (
        <tr key={item.numeroReserva}>
          <td>{item.vuelos.idVuelo}
          </td>
          <td > {item.numeroReserva}</td>
          <td > {item.vuelos.horaOrigen} {item.vuelos.ciudadOrigen} - {item.vuelos.ciudadDestino} </td>
          <td >{item.vuelos.horaDestino} {item.vuelos.ciudadDestino} - {item.vuelos.ciudadOrigen} </td>
          <td>$ {item.valorReserva}</td>
        </tr>
      ));

    return (
      <div className="container-fluid sectionContainer no-pad">
        <div className="col-xs-12 col-sm-10 col-md-9 no-pad">
          <div className="sectionContainer-gral">
            <div className="form-horizontal">
              <div className="form-group">
                <div className="col-md-12">
                  <h2>Resultado de la búsqueda:</h2>
                </div>
              </div>
              <div className="form-group">
                <div className="col-md-12">
                  <div className="table-responsive">
                    <table className="table table-hover ">
                      <thead>
                        <tr>
                          <th>Vuelo</th>
                          <th>Numero de reserva</th>
                          <th>vuelo de Ida</th>
                          <th>vuelo de Regreso</th>
                          <th>Valor</th>
                        </tr>
                      </thead>
                      <tbody>
                        {listaReservas}
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <form onSubmit={this.onFormSubmit}>
          <div className="col-xs-12 col-sm-10 col-md-3 no-pad">
            <div className="infoLateral">
              <div className="form-horizontal">
                <div className="form-group">
                  <div className="col-md-6 col-xs-12 col-sm-12">
                    <div className="messageBanner">
                      <img src={require('images/tar.png')} />
                    </div>
                  </div>
                  <br />
                  <div className="col-md-12">
                    <h2>Consulta tus reservas</h2>
                  </div>
                </div>
                <div className="form-group">
                  <div className="col-md-3">
                    <input type="text" placeholder="Ingrese su numero de cedula" />
                  </div>
                  <div className="col-md-12">
                    <a href="./"><button className="search" type="submit">Buscar Reserva</button></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </form>
      </div >
    );
  }
}

ConsultarReservas.propTypes = {
  consultarReservas: PropTypes.func,
  consultarreservas: PropTypes.object,
};

const mapStateToProps = createStructuredSelector({
  consultarreservas: makeSelectConsultarReservas(),
});

function mapDispatchToProps(dispatch) {
  return {
    consultarReservas: () => {
      axios.get('http://localhost:8085/reserva/consultar?cedula=10201124')
        .then((response) => {
          console.log(response);
          dispatch({ type: 'GUARDAR_RESPUESTA', value: response.data });
        })
        .catch((error) => {
          alert(error);
        });
    },
  };
}

const withConnect = connect(mapStateToProps, mapDispatchToProps);

const withReducer = injectReducer({ key: 'consultarReservas', reducer });
const withSaga = injectSaga({ key: 'consultarReservas', saga });

export default compose(
  withReducer,
  withSaga,
  withConnect,
)(ConsultarReservas);
