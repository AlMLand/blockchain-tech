// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract Faucet {

    constructor(){}

    function withdraw(uint withdrawAmount) public {
        require(withdrawAmount <= 100000000000000000);
        payable(msg.sender).transfer(withdrawAmount);
    }

    receive() external payable {}
}
