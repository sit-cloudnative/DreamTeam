import React from 'react'
import axios from '../util/axios'
import Router from 'next/router'

export default class extends React.Component{
    constructor(props){
        super(props)
        this.state = {

        }
        this.handleOnSearch = this.handleOnSearch.bind(this)
    }
    async handleOnSearch(e) {
        console.log(e)
        const { data } = await axios.get('/subject-service/subjects', {
            params: {
                keyword: e
            }
        })
        await localStorage.setItem('searched', JSON.stringify(data))
        await console.log(localStorage.getItem('searched'))
        console.log(window.location.href)
        Router.push({pathname: '/search'})
        if(window.location.href.indexOf('search') > -1){
            window.location.reload()
        }

    }

    render(){
        return (
            <div>
                
                <div className="form-inline my-2 my-lg-0">
                    <input className="form-control mr-sm-2" ref="search" type="search" placeholder="Search" aria-label="Search" />
                    <button className="btn btn-default" type="" onClick={async()=>{await this.handleOnSearch(this.refs.search.value)}}>Search</button>
                </div>
            </div>
        )
    }
}