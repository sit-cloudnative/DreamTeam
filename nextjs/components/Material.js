import React from 'react'
import 'isomorphic-fetch'

export default class Material extends React.Component {

    constructor() {
        super()
        this.state = {
            material: []
        }
    }

    async componentDidMount() {
        const response = await fetch('http://localhost:80/material/')
        const material = await response.json()
        this.setState({ material: material })
    }

    render() {
        return (
            <div>
                <h1>Material</h1>
                <table className="table table-hover">
                    <thead className="thead-dark">
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Name</th>
                            <th scope="col">Path</th>
                            <th scope="col">SubjectId</th>
                            <th scope="col">Uploader</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row"> {this.state.material.map(materials => <h4>{materials.materialId}</h4>)} </th>
                            <td> {this.state.material.map(materials => <h4>{materials.materialName}</h4>)} </td>
                            <td> {this.state.material.map(materials => <h4>{materials.materialPath}</h4>)} </td>
                            <td> {this.state.material.map(materials => <h4>{materials.subjectId}</h4>)} </td>
                            <td> {this.state.material.map(materials => <h4>{materials.uploader}</h4>)} </td>
                        </tr>
                    </tbody>    
                </table>

            </div>
        )
    }
}