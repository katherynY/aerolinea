import React from 'react';
import { Field, reduxForm } from 'redux-form/immutable';
import { PropTypes } from 'prop-types';
import validate from './validate';
import axios from 'axios';

const renderField = ({
  input,
  label,
  type,
  meta: { touched, error, warning } }) => (
    <div>
      <label>{label}</label>
      <div>
        <input {...input} type={type} placeholder={label} />
        {touched &&
          ((error && <span>{error}</span>) ||
            (warning && <span>{warning}</span>))}
      </div>
    </div>
  );


const FormularioConsultaVuelos = (props) => {
  const { handleSubmit, pristine, reset, submitting } = props;
  return (
    <form onSubmit={handleSubmit}>
      <div className="col-xs-12 col-sm-10 col-md-9 no-pad">
        <div className="sectionContainer-gral">
          <div className="form-horizontal">
            <div className="form-group">
              <div className="col-md-12">
                <h2>Resultados de los vuelos para:</h2>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-12">
                <div className="table-responsive">
                  <table className="table table-hover ">
                    <thead>
                      <tr>
                        <th>Hora</th>
                        <th>Superpromo</th>
                        <th>Economica</th>
                        <th>Ejecutivo</th>
                        <th>Primera clase</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>
                          10:00 am - Medellin<br></br>
                          10: 00 am - Cali
                                  </td>
                        <td>$ 230.000</td>
                        <td>$ 140.000</td>
                        <td>$ 300.000</td>
                        <td>$ 450.000</td>
                      </tr>
                      <tr>
                        <td>
                          10:00 am - Medellin<br></br>
                          10: 00 am - Cali
                                  </td>
                        <td>$ 230.000</td>
                        <td>$ 140.000</td>
                        <td>$ 300.000</td>
                        <td>$ 450.000</td>
                      </tr>
                      <tr>
                        <td>
                          10:00 am - Medellin<br></br>
                          10: 00 am - Cali
                                  </td>
                        <td>$ 230.000</td>
                        <td>$ 140.000</td>
                        <td>$ 300.000</td>
                        <td>$ 450.000</td>
                      </tr>
                      <tr>
                        <td>
                          10:00 am - Medellin<br></br>
                          10: 00 am - Cali
                                  </td>
                        <td>$ 230.000</td>
                        <td>$ 140.000</td>
                        <td>$ 300.000</td>
                        <td>$ 450.000</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className="col-xs-12 col-sm-10 col-md-3 no-pad">
        <div className="infoLateral">
          <div class="form-horizontal">
            <div className="form-group">
              <div className="col-md-12">
                <h2>Tu selección</h2>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-12">
                <label>IDA</label>
                <label>10:00 am - Medellin</label>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-12">
                <label>Regreso</label>
                <label>10:00 am - Cali</label>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-12">
                <hr></hr>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-12">
                <label>VALOR</label>
                <label>$ 450.000</label>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-12">
                <button className="search">Continuar</button>
              </div>
            </div>
            <div className="form-group">
              <div className="col-md-12">
                <a href="#">Realizar otra búsqueda</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  );
};

renderField.propTypes = {
  input: PropTypes.string,
};

export default reduxForm({
  form: 'formularioConsultaVuelos',
  validate,
})(FormularioConsultaVuelos);
