/**
*
* FloatForm
*
*/

import React from 'react';
// import styled from 'styled-components';

import { FormattedMessage } from 'react-intl';
import messages from './messages';

class FloatForm extends React.Component { // eslint-disable-line react/prefer-stateless-function
  render() {
    return (
      <div className="boxFloating">
        <div className="col-md-6 col-xs-12 col-sm-6">
          <div className="FloatForm">
            <div className="form-group tabs">
              <ul>
                <li className="active"><a href="#">Reserva tu vuelo</a></li>
                <li><a href="#">Consulta tus reservas</a></li>
              </ul>
            </div>
            <div className="form-group">
              <div className="col-md-6">
                <div className="radio">
                  <label><input type="radio" name="optradio"/>Ida</label>
                </div>
              </div>
              <div className="col-md-6">
                <div className="radio">
                  <label><input type="radio" name="optradio"/>Ida y Regreso</label>
                </div>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-6">
                <input type="text" placeholder="Ciudad Origen"/>
              </div>
              <div className="col-md-6">
                <input type="text" placeholder="Ciudad Destino"/>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-12">
                <h2>Seleccione la fecha de viaje</h2>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-6">
                <input type="text" placeholder="Fecha Ida"/>
              </div>
              <div className="col-md-6">
                <input type="text" placeholder="Fecha Regreso"/>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-6">
                <div className="radio">
                  <label><input type="radio" name="optradio"/>Solo adultos</label>
                </div>
              </div>
              <div className="col-md-6">
                <div className="radio">
                  <label><input type="radio" name="optradio"/>Niños y Adultos</label>
                </div>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-6">
                <select>
                  <option>Número de adultos</option>
                  <option>1</option>
                </select>  
              </div>
              <div className="col-md-6">
                <select>
                  <option>Número de Niños</option>
                  <option>1</option>
                </select>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-4 pull-right text-right">
                <a href="./ConsultaVuelos/"><button className="search" type="button">Buscar vuelo</button></a>
              </div>
            </div>
          </div>
        </div>
        <div className="col-md-6 col-xs-12 col-sm-12">
          <div className="messageBanner">
              <img src={require('images/tar.png')} />
              <h3>Your best choice to fly</h3>
          </div>
        </div>
      </div>
      
    );
  }
}

FloatForm.propTypes = {

};

export default FloatForm;
