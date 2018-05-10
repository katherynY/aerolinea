import React from 'react';
import { Field, reduxForm } from 'redux-form/immutable';
import { PropTypes } from 'prop-types';
import validate from './validate';


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
  )

const ConsultaVuelos = props => {
  const { handleSubmit, pristine, reset, submitting } = props
  return (
    <form onSubmit={handleSubmit}>
      <Field
        name="username"
        type="text"
        component={renderField}
        label="Username"
      />
      <Field name="email" type="email" component={renderField} label="Email" />
      <Field name="age" type="number" component={renderField} label="Age" />
      <div>
        <button type="submit" disabled={submitting}>
          Submit
        </button>
        <button type="button" disabled={pristine || submitting} onClick={reset}>
          Clear Values
        </button>
      </div>
    </form>
  )
}

renderField.propTypes = {
  input: PropTypes.string,
};

export default reduxForm({
  form: 'consultaVuelos',
  validate,
})(ConsultaVuelos)