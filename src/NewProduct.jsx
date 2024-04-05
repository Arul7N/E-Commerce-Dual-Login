import React, { useState } from 'react';
import axios from 'axios';
import './App.js'
import './index.js'
import { useNavigate } from 'react-router-dom';
import './style/style.css'
// import { ProductAdded } from './components/ProductAdded';


function NewProduct () {

  const navigate = useNavigate();

  const url = "http://localhost:8080/product/create";
  
  const [data, setData] = useState({
        productName: "",
        qty: "",
        price: "",
        imageURL: "" 
  });

const handleClick = () => {
  navigate('/home')
}

const submit = async (e) => {

  e.preventDefault();
  
  await axios.post(url,{
    productName: data.productName,
    qty: data.qty,
    price: data.price,
    imageURL: data.imageURL
  });
  navigate('/added')
  

}




function handle (e) {
  const newData = {...data}
  newData[e.target.id] = e.target.value
  setData(newData)
  console.log(newData)
}

return (
    
  
    <div className="App">
      
    <div class="custom-main">
        <div class="w-96 white-card">
          {/* <form onSubmit={(e) => submit(e)}> */}
          <div class="mt-3">
            <div>
              <label htmlFor="title" class="main-label">New Product</label>
              <hr class="mt-3 border-t-1 border-gray-400"></hr>
            </div>
          </div>

          <div class="mt-3">
            <div>
              <label htmlFor="productName" class="label">Product Name</label>
              <input type="text" onChange={(e) => handle(e)} value={data.productName} id='productName' placeholder='Product Name' class="pl-input" />
            </div>
          </div>
          
          <div class="mt-3">
            <div>
              <label htmlFor="quantity" class="label">Quantity</label>
              <input type="text" onChange={(e) => handle(e)} value={data.qty} id='qty' placeholder='Qty' class="pl-input" />
            </div>
          </div>

          <div class="mt-3">
            <div>
              <label htmlFor="Price" class="label">Price</label>
              <input type="text" onChange={(e) => handle(e)} value={data.price} id='price' placeholder='Price' class="pl-input" />
            </div>
          </div>

          <div class="mt-3">
            <div>
              <label htmlFor="imageURL" class="label">Image</label>
              <input type="text" onChange={(e) => handle(e)} value={data.imageURL} id='imageURL' placeholder='Image URL' class="pl-input" />
            </div>
          </div>

          

          <div class="mt-3 flex justify-between">
            <div>
              <button  type='submit' onClick={submit} class="green-btn" >Add Product</button>
            </div>
            <div>
              <button onClick={handleClick} class="green-btn">Home</button>
            </div>
            
          </div>
          {/* </form> */}
          
      </div>
      </div>
    </div>
    
  );
}

export default NewProduct;