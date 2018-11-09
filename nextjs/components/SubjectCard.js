import React from 'react'

class SubjectCard extends React.Component{
    constructor(props){
        super(props)
        this.state = {

        }
    }

    render(){
        return (
                <div className="col-md-4">
                    <div className="card-deck">
                        <div className="card">
                            <a href={`http://localhost:3000/subject?subject_id=${this.props.subject.subjectId}`}>
                                <img className="card-img-top" width="300" height="200" />
                                <div className="card-body">
                                    <h5 className="card-title">{this.props.subject.subjectCode} : {this.props.subject.subjectName}</h5>
                                </div>
                            </a>
                        </div>

                    </div>
                </div>
        )
    }

}
export default SubjectCard