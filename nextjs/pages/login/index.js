import React from 'react'
import {userService} from '../../util/axios'
import Head from 'next/head';
import Router from 'next/router'

export default class extends React.Component {
    constructor() {
        super()
        this.state = {
            user: {
                username: '',
                password: ''
            },
            message: ''
        }
        this.axios = {};
        this.handleLogin = this.handleLogin.bind(this)
    }

    async handleLogin(e) {
        e.preventDefault()
        console.log(this.state.username)
        console.log(this.state.password)
        const { data } = await this.axios({
            method: 'post',
            data: {
                username: this.state.username,
                password: this.state.password
            },
            url: 'user-service/login',
            headers:{
                'Access-Control-Allow-Origin' : '*'
            }
            
        })
        console.log('****************')
        console.log(data)
        localStorage.setItem('token', data.token)
        localStorage.setItem('profileId', data.username)
        let localdata = localStorage.getItem('profileId')
        if (data.username == undefined) {
            Router.push('/login')
            this.setState({ message: 'wrong username or id' })
            console.log('goto /login')
        } else {
            Router.push('/index')
        }

    }

    componentDidMount(){
        this.axios = userService(localStorage.getItem('token'))
    }

    render() {
        return (
            <div className="container">
                <Head>
                    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous" />
                    <link rel="stylesheet" href="/static/bootstrap.min.css" />
                    <link href="/static/style.css" rel="stylesheet" />

                </Head>
                <div className="d-flex justify-content-center h-100">
                    <div className="card" style={{ justifyContent: 'center', display: 'flex' }}>
                        <div className="card-header">
                            <h3>Sign In</h3>
                        </div>
                        <div className="card-body">
                            <div style={{ color: 'red' }}>{this.state.message}</div>
                            <form>
                                <div className="input-group form-group">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text"><i className="fas fa-user"></i></span>
                                    </div>
                                    <input type="text" onChange={(e) => { this.setState({ username: e.target.value }) }} className="form-control" placeholder="username" name="username" />
                                </div>
                                <div className="input-group form-group">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text"><i className="fas fa-key"></i></span>
                                    </div>
                                    <input type="password" onChange={(e) => { this.setState({ password: e.target.value }) }} className="form-control" placeholder="password" name="password" />
                                </div>
                                <div className="form-group">
                                    <button className="btn float-right login_btn" onClick={this.handleLogin} >Login</button>
                                </div>
                            </form>
                        </div>
                        <div className="card-footer">
                            <div className="d-flex justify-content-center links">
                                <a href="https://github.com/sit-cloudnative/DreamTeam" target="_blank">
                                    <i class="fa fa-github  white-text"> Our GitHub</i>
                                </a>
                                &#9400; DreamTeam & INT491 CloudNative <br />All Rights Reserved
				            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

}