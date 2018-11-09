
import SearchBar from './SearchBar'
import React from 'react'
import ProfileCard from '../components/ProfileCard'
import axios from '../util/axios'
import Router from 'next/router'
import Head from 'next/head';
import Line from '../components/Line'
import ButtonS from '../components/ButtonS'

export default class NavBar extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      profile: {
        studentId: '',
        firstname: '',
        lastname: '',
      }
    }
  }

  async componentDidMount() {
    let user = localStorage.getItem('profileId')
    let { data } = await axios.get('profile-service/profile/' + user)
    this.setState({ profile: data })
    console.log(data)
  }



  render() {
    return (


      <div className="">

        <nav className="navbar navbar-expand-lg navbar navbar-dark bg-dark">
          <a className="navbar-brand" href="#">Dream-Learning <i className="fa fa-cloud" style={{ fontSize: 35, color: 'aquamarine' }}></i></a>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>

          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item active">
                <a id="home" className="nav-link" href="/">Home <span className="sr-only">(current)</span></a>
              </li>
              <li>
                <a id="subjects" className="nav-link" href="/subjects">All Curriculum <span className="sr-only">(current)</span></a>
              </li>
            </ul>
            <SearchBar handleOnSearch={this.props.handleOnSearch} />
          </div>
        </nav>
      </div>



    )
  }
}