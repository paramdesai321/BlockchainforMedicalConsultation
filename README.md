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
<P>We have used a hex mixture of ECDSA(Elliptical Curve Digital Signature Algorithm) and SHA-256.
--> We are using secpr256r1 Elliptical curve, which uses mathematical two point sum method to generate large prime numbers.</P>

**Dataset**
-This is dataset is based on a paper published in the National Library of Medicine: A dataset of simulated patient-physician medical interviews with a focus on respiratory cases(https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9203765/)
-The Dataset was made by the students and researchers of Western University and Waterloo University in Canada.

**Results of Blockchain using ECDSA**

_NOTE: Block #0 secures the first five messages of doctor and has a pointer to null_
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

_NOTE: Block #1 secures the first five messages of patient and has a pointer to Block #0_
Block #:1
Block Hash: 3041020100301306072A8648CE3D020106082A8648CE3D030107042730250201010420BCE76CCCA346D9A2B0505921D94C4CD7A167F65F30E0101E677701563CA93A3B
Previous Hash: 3041020100301306072A8648CE3D020106082A8648CE3D030107042730250201010420A98352EE0F53C6CA119258A0D34FB9D9604FB2BAE1A0E3D15A2EF93FBABADB54
Data:
P: Sure, I'm I'm just having a lot of chest pain and and so I thought I should get it checked out.
P: Sure 39, I'm a male.
P: It started last night, but it's becoming sharper.
P: It's located on the left side of my chest.
P: So I guess it would be a couple of hours


**Comparsion with RSA**
Rsa is a cryptographic number system that uses large prime number factorization.

**Results with RSA**
Block #0
Previous Hash:null
Original message: P: Sure, I'm I'm just having a lot of chest pain and and so I thought I should get it checked out.
Hash: 3425093439138618451633153113277972634427110354395713328820347408627265931353947613823059972744188838371449124733482944724923068302760461495420198249953152627116348109104082276733430930043621452627911384073461725398919928976724462915355871004673598227652716990748672927149864061243565329679931876736513207528444131469543098906245978389073326090227733654402398789701947609603063156839704011124677129039917626339458747746691910597258210244216435609939538700416183172740684488401175344681277480656648775807550331737771756226197678538492149160220368633384540234752306799657376806835622899081787693386261519398125922202871
Decrypted message: P: Sure, I'm I'm just having a lot of chest pain and and so I thought I should get it checked out.

**Comparsions with RSA**: After our research and testing we found that ECDSA is has 1/4th of the hash value as RSA, and is almost 3 times faster and more randomized.

