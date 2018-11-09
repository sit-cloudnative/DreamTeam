import React from 'react'

class Card extends React.Component {
    constructor(props) {
        super(props)
        this.state = {

        }
    }

    render() {
        return (
                <div class="col-md-4" style={{padding:'0px',margin:'0px'}}>
                    <div className="card-deck" style={{ marginBottom: '30px', padding:'20px'}}>
                        <div className="card">
                            <a href={`http://localhost:3000/video?video_id=${this.props.videoId}`} >
                                <img className="card-img-top" src={this.props.image} alt="Card image cap"
                                    width="400" height="350" />
                                <div className="card-body">
                                    <h5 className="card-title">{this.props.lecturer}</h5>
                                    <div className="card-footer">
                                        <small className="text-muted">{this.props.lecturer} ♥2018-08-24 00:00:00</small>
                                    </div>
                                </div>
                            </a>
                            <p className="card-text">...</p>
                        </div>

                    </div>
                </div>
        )
    }

}
export default Card