import React from "react"
import '../style/style.css';

export default function Delete () {

    return (
        <div className="custom-main">
            <div className="white-card w-1/2">
                <div class="mt-3">
                    <div>
                        <label htmlFor="title" class="main-label">Delete Product</label>
                        <hr class="mt-3 border-t-1 border-gray-400"></hr>
                    </div>
                </div>

                <div class="mt-3">
                    <div>
                        <label htmlFor="productName" class="label">Delete by Product Name</label>
                        <input type="text" id='productName' placeholder='Product Name' class="pl-input" />
                    </div>
                </div>

                <div className="flex justify-center">
                    <button  type='submit' class="green-btn" >Search Product</button>
                </div>
            </div>
        </div>
    )
}