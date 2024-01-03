# BlockchainforMedicalConsultation

This is a Reaserch Project for COMP 282: Advanced Data Structures under Dr Wen-Chin Hsu. We are using Blockchain techonology to make medical consultation and data secure than ever. We are using various cryptographic algorithms like SHA256,SHA26d and Elliptical Curve Digital Signature Algorithm to protect confidential and private data.
Not only that but also we're using Ethereum Smart contracts made using solidity to ensure a secure and impartial liason between parties(blocks) of the Decenterlized System.
**Overview of the Project**
**Blocks**
Eack Blocks Contain:
1. Previous Hash
2. Data: our each block contains 5 messages from either party
   ![image](https://github.com/paramdesai321/BlockchainforMedicalConsultation/assets/123131116/2d2eba81-c036-4443-ba89-612a2ef8aa12)
   Fig: Blocks in the blockchain
   
**Encrypting Algorithms**
We have used a hex mixture of ECDSA(Elliptical Curve Digital Signature Algorithm) and SHA-256.
--> We are using secpr256r1 Elliptical curve, which uses mathematical two point sum method to generate large prime numbers.


**Dataset**
-This is dataset is based on a paper published in the National Library of Medicine: A dataset of simulated patient-physician medical interviews with a focus on respiratory cases(https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9203765/)
-The Dataset was made by the students and researchers of Western University and Waterloo University in Canada.

**Results of Blockchain using ECDSA**
NOTE: Block #0 secures the first five messages of doctor and has a pointer to null
Block #:0
Block Hash: 3041020100301306072A8648CE3D020106082A8648CE3D030107042730250201010420A98352EE0F53C6CA119258A0D34FB9D9604FB2BAE1A0E3D15A2EF93FBABADB54
Previous Hash: null
Data:
D: What brought you in today?
D: OK, before we start, could you remind me of your gender and age?
D: OK, and so when did this chest pain start?
D: OK, and where is this pain located?
D: OK, and, so how long has it been going on for then if it started last night?
Block Verification: true

NOTE: Block #1 secures the first five messages of patient and has a pointer to Block #0
Block #:1
Block Hash: 3041020100301306072A8648CE3D020106082A8648CE3D030107042730250201010420BCE76CCCA346D9A2B0505921D94C4CD7A167F65F30E0101E677701563CA93A3B
Previous Hash: 3041020100301306072A8648CE3D020106082A8648CE3D030107042730250201010420A98352EE0F53C6CA119258A0D34FB9D9604FB2BAE1A0E3D15A2EF93FBABADB54
Data:
P: Sure, I'm I'm just having a lot of chest pain and and so I thought I should get it checked out.
P: Sure 39, I'm a male.
P: It started last night, but it's becoming sharper.
P: It's located on the left side of my chest.
P: So I guess it would be a couple of hours




**Comparsions with RSA**: After our research and testing we found that ECDSA is has 1/4th of the hash value as RSA, and is almost 3 times faster and more randomized.

