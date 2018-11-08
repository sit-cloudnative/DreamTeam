import React from 'react'
import axios from '../../util/axios'
import Head from 'next/head';

export default class extends React.Component {
    constructor() {
        super()
        this.state = {

        }
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
                    <div className="card" style={{justifyContent: 'center', display: 'flex'}}>
                        <div className="card-header">
                            <h3>Sign In</h3>
                        </div>
                        <div className="card-body">
                            <form>
                                <div className="input-group form-group">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text"><i className="fas fa-user"></i></span>
                                    </div>
                                    <input type="text" className="form-control" placeholder="username" />
                                </div>
                                <div className="input-group form-group">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text"><i className="fas fa-key"></i></span>
                                    </div>
                                    <input type="password" className="form-control" placeholder="password" />
                                </div>
                                <div className="form-group">
                                    <input type="submit" value="Login" className="btn float-right login_btn" />
                                </div>
                            </form>
                        </div>
                        <div className="card-footer">
                            <div className="d-flex justify-content-center links">
                                &#9400; DreamTeam & INT491 CloudNative <br />All Rights Reserved
				            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

}